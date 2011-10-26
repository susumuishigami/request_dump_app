package susumu.ishigami.request_dump.controller;

import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slim3.controller.Controller;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import susumu.ishigami.request_dump.meta.RequestDumpMeta;
import susumu.ishigami.request_dump.model.RequestDump;

public class ViewController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>リクエストダンプ</title></head>");
        writer.println("<body><h1>リクエストダンプ</h1>");
        
        RequestDumpMeta REQUEST_DUMP_META = RequestDumpMeta.get();
        List<RequestDump> list = Datastore
            .query(REQUEST_DUMP_META)
            .sort(REQUEST_DUMP_META.createdAt.desc)
            .limit(50)
            .asList();
        
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        writer.println("<table>");
        for (RequestDump dump : list) {
            writer.println("<tr>");
            writer.print("<td width='20%'>");
            writer.print(fmt.format(dump.getCreatedAt()));
            writer.println("</td>");
            writer.print("<td width='5%'>");
            writer.print(dump.getPort());
            writer.println("</td>");
            writer.print("<td width='20%'>");
            writer.print(dump.getRequestUri());
            writer.println("</td>");
            writer.print("<td width='30%'>");
            writer.print(dump.getParameters().replace("\n", "<br />"));
            writer.println("</td>");
            writer.print("<td width='25%'>");
            writer.print(dump.getHeaders().replace("\n", "<br />"));
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("<a href='./clear'>クリア</a>");
        writer.println("</body></html>");
        response.flushBuffer();
        return null;
    }
}
