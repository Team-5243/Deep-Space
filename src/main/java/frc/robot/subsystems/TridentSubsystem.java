/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class TridentSubsystem extends Subsystem {

    //Includes Cargo and Hatch Mechanisms

    private WPI_TalonSRX leftFlywheels, rightFlywheels, leftPivot, rightPivot;

    public TridentSubsystem() {
        leftFlywheels = new WPI_TalonSRX(RobotMap.leftFlywheels.get());
        rightFlywheels = new WPI_TalonSRX(RobotMap.rightFlywheels.get());

        leftPivot = new WPI_TalonSRX(RobotMap.leftPivot.get());
        rightPivot = new WPI_TalonSRX(RobotMap.rightPivot.get());

        rightFlywheels.follow(leftFlywheels);
        rightPivot.follow(leftPivot);

        leftFlywheels.setInverted(true);


    }

    public void spinyBois(boolean intake) {
        leftFlywheels.set(intake ? -.5d : 1d);   
    }

    public void stopFlywheels(){
        leftFlywheels.set(0);
    }

    public void pivotDown(){
        leftPivot.set(0.5); //rightPivot follows left so we only need to set left
    }

    public void pivotUp(){
        leftPivot.set(-0.5); //rightPivot follows left so we only need to set left
        //lowkey need to check again after we get to test with the real robot
    }

    public void stopPivots(){
        leftPivot.set(0);
    }
    
    @Override
    public void initDefaultCommand() {
    }



}
