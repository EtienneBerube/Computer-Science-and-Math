import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;

  // Clock pane's width and height
  private double w = 250, h = 250;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    paintClock();
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }

  /** Return clock pane's width */ 
  public double getW() {
    return w;
  }
  
  /** Set clock pane's width */ 
  public void setW(double w) {
    this.w = w;
    paintClock();
  }
  
  /** Return clock pane's height */ 
  public double getH() {
    return h;
  }
  
  /** Set clock pane's height */ 
  public void setH(double h) {
    this.h = h;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    getChildren().clear();
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
 getChildren().clear();    
// Initialize clock parameters
    double clockRadius = Math.min(w, h) * 0.8 * 0.5;
    double centerX = w / 2;
    double centerY = h / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.TRANSPARENT);
    circle.setStroke(Color.BLACK);
    
    for(int i = 0; i < 12; i++){
          double co = (i%5==0) ? 0.80:0.80;
          this.getChildren().add(new Text(centerX+((clockRadius*co)*Math.cos(i*5 * 2*Math.PI/60+(Math.PI/2)))-5,(centerY-((clockRadius*co)*Math.sin(i*5* 2*Math.PI/60+(Math.PI/2))))+6,""+(12-i)));
    }
    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
      Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
      Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
      Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * 
      Math.cos(minute * (2 * Math.PI / 60));
    //Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    Line mLine = new Line();
    mLine.setStartX(centerX);
    mLine.setStartY(centerY);
    mLine.setEndX(xMinute);
    mLine.setEndY(minuteY);
    
    mLine.setStroke(Color.BLUE);
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    
    
    for(int i = 0; i < 60; i++){
          double co = (i%5==0) ? 0.90:0.96;
          this.getChildren().add(new Line(centerX+((clockRadius*co)*Math.cos(i * 2*Math.PI/60)),(centerY-((clockRadius*co)*Math.sin(i* 2*Math.PI/60))),centerX+(clockRadius*Math.cos(i*2*Math.PI/60)), centerY-(clockRadius*Math.sin(i*2*Math.PI/60))));
      }  
   
    getChildren().addAll(circle, sLine, mLine, hLine);
  }
}