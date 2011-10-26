package susumu.ishigami.request_dump.controller;

import java.io.PrintWriter;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import susumu.ishigami.request_dump.meta.RequestDumpMeta;
import susumu.ishigami.request_dump.model.RequestDump;

public class ClearController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        RequestDumpMeta REQUEST_DUMP_META = RequestDumpMeta.get();
        List<RequestDump> list = Datastore
            .query(REQUEST_DUMP_META)
            .asList();
        
        for (RequestDump dump : list) {
            gtx.delete(dump.getKey());
        }
        gtx.commit();
        writer.println("data cleared");
        response.flushBuffer();
        return null;
    }
}
