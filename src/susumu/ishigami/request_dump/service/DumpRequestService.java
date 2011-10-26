package susumu.ishigami.request_dump.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slim3.datastore.Datastore;

import susumu.ishigami.request_dump.model.RequestDump;


public class DumpRequestService {

    public void dump(HttpServletRequest request) {
        RequestDump dump = new RequestDump();
        dump.setPort(request.getServerPort());
        dump.setRemoteHost(request.getRemoteHost());
        dump.setRequestUri(request.getRequestURL() + "?" + request.getQueryString());
        dump.setCreatedAt(new Date());
        Enumeration<?> e = request.getParameterNames();
        String s = "";
        TreeMap<String, String> sorter = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            sorter.put(key, Arrays.toString(request.getParameterValues(key)));
        }
        for (Map.Entry<String, String> entry : sorter.entrySet()) {
            s += "\n" + entry.getKey() + "=" + entry.getValue();
        }
        dump.setParameters(s);
        s = "";
        sorter.clear();
        e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = "";
            Enumeration<?> e2 = request.getHeaders(key);
            while (e2.hasMoreElements()) {
                if (value.length() > 0) {
                    value += ",";
                }
                value += e2.nextElement();
            }
            sorter.put(key, value);
        }
        for (Map.Entry<String, String> entry : sorter.entrySet()) {
            s += "\n" + entry.getKey() + "=" + entry.getValue();
        }
        dump.setHeaders(s);
        Datastore.put(dump);
    }
}
