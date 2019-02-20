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
  
  private Spark actuadorMotorRear;
  private Spark actuadorMotorFront;
  private Spark elevatorMotor;
  @Override
  public void initDefaultCommand() {
    actuadorMotorFront = new Spark(RobotMap.ActuadorFront);
    actuadorMotorRear = new Spark(RobotMap.ActuadorRear);
    elevatorMotor = new Spark(RobotMap.Elevador);
  }

  public void ActuadorFrontUp() {
    actuadorMotorFront.set(RobotMap.MAX_MOTOR_POWER);
  }

  public void ActuadorFrontDawn() {
    actuadorMotorFront.set(RobotMap.MAX_MOTOR_POWER_NEGATIVE);
  }

  public void ActuadorStopFront() {
    actuadorMotorFront.set(RobotMap.STOP_MOTOR);
  }

  public void ActuadorRearUp() {
    actuadorMotorRear.set(RobotMap.MAX_MOTOR_POWER);
  }

  public void ActuadorRearDawn() {
    actuadorMotorRear.set(RobotMap.MAX_MOTOR_POWER_NEGATIVE);
  }

  public void ActuadorStopRear() {
    actuadorMotorRear.set(RobotMap.STOP_MOTOR);
  }
  
  public void elevatorMotorPresed(){
    elevatorMotor.set(RobotMap.MAX_MOTOR_POWER);
  }
  public void elevatorMotorReleased()
  {
    elevatorMotor.set(RobotMap.STOP_MOTOR);
  }
  public void elevatorMotorPresedDawn(){
    elevatorMotor.set(RobotMap.MAX_MOTOR_POWER_NEGATIVE);
  }
  
}
