package com.willy.smith.chart;

import com.willy.smith.Main;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class SmithChart
  extends Parent
{
  private static final double radio = 120.0D;
  private static final double origenX = Main.getWidth() / 2.0D + radio;
  private static final double origenY = Main.getHeight() / 2.0D;
  
  public SmithChart()
  {
    double rl = 0.0D;
    double rx = 1.0D;
    for (int i = 0; i < 40; i++) {
      if (i < 20)
      {
        if (i == 0)
        {
          Circle cPrincipal = drawCircleResistence(rl, Color.GREEN);
          getChildren().addAll(new Node[] { cPrincipal });
        }
        else
        {
          rl += 0.05D;
					Circle localCircle1 = drawCircleResistence(rl, Color.BLACK);
        }
      }
      else
      {
        Circle c = drawCircleResistence(rx, Color.BLACK);
        rx += 0.25D;
      }
    }
    double x = 1.0D;
    
    double radio = 120.0D;
    
    double xl = 1.0D;
    double y = 1.0D / xl;
    double ratio = 1.0D / xl;
    
    Circle c1 = new Circle(origenX + x * radio, origenY + y * radio, ratio * radio, Color.TRANSPARENT);
    c1.setStroke(Color.BLACK);
    c1.setStrokeWidth(2.0D);
    
    double yp = 2.0D * xl / (1.0D + xl * xl);
    double xp = 1.0D - yp / xl;
    
    Circle redpoint = new Circle(origenX + xp * radio, origenY + yp * radio, 4.0D, Color.RED);
    Circle greenpoint = new Circle(origenX + radio, origenY, 4.0D, Color.GREEN);
    Circle centerpoint = new Circle(origenX, origenY, 4.0D, Color.AQUA);
    
    Line line1 = new Line(redpoint.getCenterX(), redpoint.getCenterY(), greenpoint.getCenterX(), greenpoint.getCenterY());
    line1.setStroke(Color.BLUE);
    line1.setStrokeWidth(2.0D);
    
    Arc a = new Arc();
    a.setCenterX(c1.getCenterX());
    a.setCenterY(c1.getCenterY());
    a.setRadiusX(radio);
    a.setRadiusY(radio);
    double gp = (greenpoint.getCenterX() - c1.getCenterX()) / radio;
    double rp = (redpoint.getCenterX() - c1.getCenterX()) / radio;
    double gpangle = 180.0D * Math.acos(gp) / 3.141592653589793D;
    double rpangle = 180.0D * Math.acos(rp) / 3.141592653589793D;
    double lenght = rpangle - gpangle;
    a.setStartAngle(gpangle);
    a.setLength(lenght);
    a.setFill(Color.TRANSPARENT);
    a.setStroke(Color.BLUEVIOLET);
    a.setType(ArcType.OPEN);
    
    getChildren().addAll(new Node[] { centerpoint, greenpoint, redpoint, a });
  }
  
  private Circle drawCircleResistence(double rl, Color color)
  {
    double xc = rl / (1.0D + rl);
    double yc = 0.0D;
    double ratio = 1.0D / (1.0D + rl);
    
    Circle c1 = new Circle(origenX + xc * radio, origenY + yc, ratio * radio, Color.TRANSPARENT);
    c1.setStroke(color);
    c1.setStrokeWidth(1.0D);
    return c1;
  }
}
