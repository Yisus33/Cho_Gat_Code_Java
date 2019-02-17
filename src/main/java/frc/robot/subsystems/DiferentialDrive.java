/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// importamos los subsistemas
import edu.wpi.first.wpilibj.command.Subsystem;
// importamos los controladores
import edu.wpi.first.wpilibj.Spark;
// importamos el robot diferencial
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// importamos el control de velocidad
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// importamos el rpbpt map
import frc.robot.RobotMap;

public class DiferentialDrive extends Subsystem {
  // Creando los motores para el robot diferencial
  private Spark MotorRighRear; //
  private Spark MotorRightFront; //
  
  private Spark MotorLeftRear; //
  private Spark MotorLeftFront; // 
  
  private DifferentialDrive mecanismoPrincipal;
  
  @Override
  public void initDefaultCommand() {
    // definiendo los controladores de los motores derechos
    MotorRighRear = new Spark(RobotMap.MotorRightRear);
    MotorRightFront = new Spark(RobotMap.MotorRightFront);
    // definiendo los controladores de los motores izquierdos
    MotorLeftRear = new Spark(RobotMap.MotorLeftRear);
    MotorLeftFront = new Spark(RobotMap.MotorLeftFrond);   
  
    // agrupando los controladores dada una configuración diferencial
    var m_right = new SpeedControllerGroup(MotorRightFront, MotorRighRear);
    var m_left = new SpeedControllerGroup(MotorLeftFront, MotorLeftRear);
  
    mecanismoPrincipal = new DifferentialDrive(m_left, m_right);
  }

  public void Drive(double ySpeed, double xSpeed)
  {
    // tomando los datos de traslacion del joystick
    mecanismoPrincipal.arcadeDrive(-ySpeed, xSpeed);
  }

}
