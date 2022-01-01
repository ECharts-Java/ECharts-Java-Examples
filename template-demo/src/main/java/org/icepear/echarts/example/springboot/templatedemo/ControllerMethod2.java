package org.icepear.echarts.example.springboot.templatedemo;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.render.Engine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMethod2 {

    // The GetMapping is to differiate with the first method
    @GetMapping("/option")
    public String index() {
        Line lineChart = new Line()
                .addXAxis(new CategoryAxis()
                        .setData(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" })
                        .setBoundaryGap(false))
                .addYAxis()
                .addSeries(new LineSeries()
                        .setData(new Number[] { 820, 932, 901, 934, 1290, 1330, 1320 })
                        .setAreaStyle(new LineAreaStyle()));
        Engine engine = new Engine();
        Handlebars handlebars = new Handlebars();
        String html = "";
        try {
            Template template = handlebars.compile("templates/index2");
            html = template.apply(engine.renderJsonOption(lineChart));
        } catch (IOException e) {
            System.out.println("template file not found");
        }
        return html;
    }

}
