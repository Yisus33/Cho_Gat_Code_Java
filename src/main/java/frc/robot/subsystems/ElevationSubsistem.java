/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
public class ElevationSubsistem extends Subsystem {
  
  private Spark ActuadorMotorRear;
  private Spark ActuadorMotorFront;
  
  @Override
  public void initDefaultCommand() {
    ActuadorMotorFront = new Spark(RobotMap.ActuadorFront);
    ActuadorMotorRear = new Spark(RobotMap.ActuadorRear);
  }
  
  public void ActuadorFrontUp(){
    ActuadorMotorFront.set(RobotMap.MAX_MOTOR_POWER);
  }
  public void ActuadorFrontDawn(){
    ActuadorMotorFront.set(RobotMap.MAX_MOTOR_POWER_NEGATIVE);
  }
  public void ActuadorStopFront(){
    ActuadorMotorFront.set(RobotMap.STOP_MOTOR);
  }
  public void ActuadorStopRear(){
    ActuadorMotorRear.set(RobotMap.STOP_MOTOR);
  }
  public void ActuadorRearUp(){
    ActuadorMotorRear.set(RobotMap.MAX_MOTOR_POWER);
  }  
  public void ActuadorRearDawn(){
    ActuadorMotorRear.set(RobotMap.MAX_MOTOR_POWER_NEGATIVE);
  }
  
}
