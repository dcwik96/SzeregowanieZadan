package Hu;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

import javax.swing.*;
import java.awt.*;

public class GraphVisualisation extends JApplet {
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;


    public void init(HuAlgorithm path) {
        ListenableGraph<String, DefaultEdge> g =
                new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));

        // create a visualization using JGraph, via an adapter
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);

        for (Task task : path.getTasks()) {
            g.addVertex(String.valueOf(task.getId()));
        }

        for (Task task : path.getTasks()) {
            if (!task.getSuccessors().isEmpty()) {
                for (int i : task.getSuccessors()) {
                    g.addEdge(String.valueOf(task.getId()), String.valueOf(i));
                }
            }

            mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

            int radius = 100;
            layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
            layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
            layout.setRadius(radius);
            layout.setMoveCircle(true);

            layout.execute(jgxAdapter.getDefaultParent());
        }
    }
}
