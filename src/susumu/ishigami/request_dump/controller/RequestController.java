package susumu.ishigami.request_dump.controller;

import java.io.PrintWriter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import susumu.ishigami.request_dump.model.Setting;
import susumu.ishigami.request_dump.service.DumpRequestService;

import com.google.appengine.api.datastore.Key;

public class RequestController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        DumpRequestService service = new DumpRequestService();
        service.dump(request);
        
        Key settingKey = Datastore.createKey(Setting.class, 1);
        Setting setting = Datastore.getOrNull(Setting.class, settingKey);
        if (setting != null) {
            String responseLines = setting.getResponseLines();
            if (responseLines != null) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.println(setting.getResponseLines());
                response.flushBuffer();
            }
        }
        return null;
    }
}
