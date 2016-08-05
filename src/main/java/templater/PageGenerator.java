package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created by roman on 06.08.16.
 */
public class PageGenerator {
    private static final String HTML_DIR = "templares";
    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    private PageGenerator() {
        cfg = new Configuration();
    }

    public static PageGenerator instance(){
        if(pageGenerator==null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }

    public String getPage(String filename, Map<String,Object> data){
        Writer stream = new StringWriter();
        try {
            Template template = cfg.getTemplate(filename, HTML_DIR);
            template.process(data,stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return stream.toString();
    }
}
