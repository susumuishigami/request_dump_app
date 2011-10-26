package susumu.ishigami.request_dump.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RequestTest extends AppEngineTestCase {

    private RequestDump model = new RequestDump();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
