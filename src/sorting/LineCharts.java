package sorting;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class LineCharts extends ApplicationFrame{
    private String xName, yName, graphName;
    private long[][] datagroups;
    public LineCharts(String s, String xName, String yName, String graphName, long[][] datagroups) throws IOException {
        super(s);
        this.xName = xName;
        this.yName = yName;
        this.graphName = graphName;
        this.datagroups = datagroups;
        setContentPane(createDemoLine(xName, yName, graphName, datagroups));
    }
    public static void run(String xName, String yName, String graphName, long[][] datagroups) throws IOException {
        LineCharts fjc = new LineCharts("Graph", xName, yName,graphName, datagroups);
        fjc.pack();
        RefineryUtilities.centerFrameOnScreen(fjc);
        fjc.setVisible(true);
    }
    //Generate the panel for the graph
    public static JPanel createDemoLine(String xName, String yName, String graphName, long[][] datagroups) throws IOException {
        JFreeChart jfreechart = createChart(createDataset(datagroups), xName, yName, graphName);
        ChartUtilities.saveChartAsJPEG(new File(graphName + ".jpeg"), jfreechart, 700, 600);
        return new ChartPanel(jfreechart);
    }

    // Generate JFreeChart
    public static JFreeChart createChart(XYDataset linedataset, String xName, String yName, String graphName) {
        //定义图表对象
        JFreeChart chart = ChartFactory.createXYLineChart(graphName, // chart title
                xName, // domain axis label
                yName, // range axis label
                linedataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );
        XYPlot plot = chart.getXYPlot();
        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        rangeAxis.setUpperMargin(0.20);
        rangeAxis.setLabelAngle(Math.PI / 2.0);
        return chart;
    }
    //Generate dataset
    public static XYDataset createDataset(long[][] datagroups) {

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Insert Sort");
        XYSeries series2 = new XYSeries("Select Sort");
        XYSeries series3 = new XYSeries("Bubble Sort");
        XYSeries series4 = new XYSeries("Merge Sort");
        XYSeries series5 = new XYSeries("Quick Sort");

        //fill series1
        for(int i=0; i<datagroups[1].length; i++){
            series1.add((double)datagroups[0][i], (double)datagroups[1][i]);
        }

        //fill series2
        for(int i=0; i<datagroups[2].length; i++){
            series2.add((double)datagroups[0][i], (double)datagroups[2][i]);
        }

        //fill series3
        for(int i=0; i<datagroups[3].length; i++){
            series3.add((double)datagroups[0][i], (double)datagroups[3][i]);
        }

        //fill series4
        for(int i=0; i<datagroups[4].length; i++){
            series4.add((double)datagroups[0][i], (double)datagroups[4][i]);
        }

        //fill series5
        for(int i=0; i<datagroups[5].length; i++){
            series5.add((double)datagroups[0][i], (double)datagroups[5][i]);
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);

        return dataset;
    }


    // public static void main(String[] args) throws IOException {
    //     String xName = "x axixs";
    //     String yName = "y axixs";
    //     String graphName = "graph";
    //     long[][] datagroups = new long[6][5];
    //     datagroups[0] = new long[]{1, 2, 3, 4, 5};
    //     datagroups[1] = new long[]{5, 4, 9, 10,3};
    //     datagroups[2] = new long[]{2,6,7,11,5};
    //     datagroups[3] = new long[]{19,15,22,17,4};
    //     datagroups[4] = new long[]{4,9,11,15,20};
    //     datagroups[5] = new long[]{10, 19, 4,7, 18};
    //     run(xName, yName, graphName, datagroups);
    // }
}
