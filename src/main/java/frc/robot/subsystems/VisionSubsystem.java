/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Add your docs here.
 */
public class VisionSubsystem extends Subsystem {
  
  //Includes Network Table from the Limelight Camera

  private NetworkTable table;
  
  public VisionSubsystem(){
    table = NetworkTableInstance.getDefault().getTable("limelight");

    //Default: LED is Off and Camera is set to Driver Mode
    setLed(1);
    setCamMode(1);
  }

  public NetworkTable getTable() {
    return table;
  }

  public double getX() {
    return table.getEntry("tx").getDouble(0.0);
  }

  public double getY() {
    return table.getEntry("ty").getDouble(0.0);
  }

  public double getArea() {
    return table.getEntry("ta").getDouble(0.0);
  }

  public double getShortestSide() {
    return table.getEntry("tshort").getDouble(0.0);
  }

  public double getLongestSide() {
    return table.getEntry("tlong").getDouble(0.0);
  }

  public double getHorizontal() {
    return table.getEntry("thor").getDouble(0.0);
  }

  public double getVertical() {
    return table.getEntry("tvert").getDouble(0.0);
  }

  public double getVerticalOffset() {
    return table.getEntry("ty").getDouble(0.0);
  }

  public double getHorizontalOffset() {
    return table.getEntry("tx").getDouble(0.0);
  }

  /*
  LED Mode:
  0 - Use the LED Mode set in current pipeline
  1 - Off
  2 - Blink
  3 - On

  Cam Mode:
  0 - Vision
  1 - Driver
  */

  public void setLed(int mode) {
    table.getEntry("ledMode").setNumber(mode);
  }

  public void setCamMode(int mode) {
    table.getEntry("camMode").setNumber(mode);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
