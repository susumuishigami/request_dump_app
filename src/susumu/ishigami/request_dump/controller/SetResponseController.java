package susumu.ishigami.request_dump.controller;

import java.io.PrintWriter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import susumu.ishigami.request_dump.model.Setting;

import com.google.appengine.api.datastore.Key;

public class SetResponseController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        
        Key settingKey = Datastore.createKey(Setting.class, 1);
        Setting setting = Datastore.getOrNull(Setting.class, settingKey);
        if (setting == null) {
            setting = new Setting();
            setting.setKey(settingKey);
        }
        setting.setResponseLines(request.getParameter("RESPONSE_LINES"));
        Datastore.put(setting);
        
        writer.println("response setted:");
        writer.println(setting.getResponseLines());
        response.flushBuffer();
        return null;
    }
}
