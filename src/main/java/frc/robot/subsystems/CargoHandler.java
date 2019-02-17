/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
// importamos los controladores de los motores
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;;

public class CargoHandler extends Subsystem {
  // definiendo el motor para el canon upper y botton
  private Spark canonUpperMotor; // motor de arriba 
  private Spark canonBottonMotor; // motor de abajo
  // definiendo el motor para el canon arm
private Spark canonArmMotor;

  @Override
  public void initDefaultCommand() {
    canonUpperMotor = new Spark(RobotMap.MotorCanonUpper);
    canonBottonMotor = new Spark(RobotMap.MotorsCanonBotton);
    canonArmMotor = new Spark(RobotMap.MotorCanonArm);
  }

  
}
