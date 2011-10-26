package susumu.ishigami.request_dump.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DumpRequestTest extends AppEngineTestCase {

    private DumpRequestService service = new DumpRequestService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
