package ut.com.pbueno.atlassian.stash.plugins;

import org.junit.Test;
import com.pbueno.atlassian.stash.plugins.api.MyPluginComponent;
import com.pbueno.atlassian.stash.plugins.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}