/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import frc.robot.subsystems.DifferentialDriveTrain;
import frc.robot.subsystems.ElevationSubsistem;
import frc.robot.subsystems.HatchPanelHandler;
import frc.robot.subsystems.CargoHandler;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  // definimos una instancia de joystick
  public Joystick mStick;
  public Joystick Xbox;
  // sistema principal
  private DifferentialDriveTrain mainDrive;
  private CargoHandler cargoHandler;
  // compresor 
  private Compressor compresor;
  private HatchPanelHandler hp_handler;
  private ElevationSubsistem elevation;

  public OI(){
    // constructor
    mStick = new Joystick(RobotMap.ACTUAL_USB_PORT);
    Xbox = new Joystick(RobotMap.Control_2);
    compresor = new Compressor(0);
    mainDrive = new DifferentialDriveTrain();
    cargoHandler = new CargoHandler();
    hp_handler = new HatchPanelHandler();
    elevation = new ElevationSubsistem();
  }
  
  public double getSliderData(){
    return mStick.getRawAxis(RobotMap.SLIDER_AXIS_PORT);
  }

  public boolean canonLauncherPressed(){
    return mStick.getRawButtonPressed(RobotMap.LAUNCHER_BUTTON_NUMBER);
  }

  public boolean canonLauncherReleased(){
    return mStick.getRawButtonReleased(RobotMap.LAUNCHER_BUTTON_NUMBER);
  }

  public boolean canonSuckerPressed(){
    return mStick.getRawButtonPressed(RobotMap.SUCKER_BUTTON_NUMBER);
  }

  public boolean canonSuckerReleased() {
    return mStick.getRawButtonReleased(RobotMap.SUCKER_BUTTON_NUMBER);
  }

  public boolean button_3_Pressed(){
    return mStick.getRawButtonPressed(RobotMap.BUTTON_PORT_3);
  }

  public boolean button_3_Released() {
    return mStick.getRawButtonReleased(RobotMap.BUTTON_PORT_3);
  }

  public boolean button_5_Pressed(){
    return mStick.getRawButtonPressed(RobotMap.BUTTON_PORT_5);
  }

  public boolean button_5_Released(){
    return mStick.getRawButtonReleased(RobotMap.BUTTON_PORT_5);
  }

  public double getZAxis(){
    // conseguir datos del slider
    return mStick.getRawAxis(RobotMap.SLIDER_AXIS_PORT);
  }
  public boolean Compresor_Pressed(){
    return mStick.getRawButtonPressed(RobotMap.Compresor);
  } 
  public boolean Compresor_Released(){
    return mStick.getRawButtonReleased(RobotMap.Compresor);
  }
  // botones del xbox
  public boolean Acutuador_Rear_UP_Pessed(){
    return Xbox.getRawButtonPressed(RobotMap.ActuadorRearButtonUp);
  }
  public boolean Actuador_Rear_UP_Released(){
    return Xbox.getRawButtonReleased(RobotMap.ActuadorRearButtonUp);
  }
  public boolean Actuador_Fornt_UP_Pressed(){
    return Xbox.getRawButtonPressed(RobotMap.ActuadorFrontButtonUp);
  }
  public boolean Actuador_Front_UP_Released(){
    return Xbox.getRawButtonReleased(RobotMap.ActuadorFrontButtonUp);
  }
  public boolean Actuador_Front_Dawn_Pressed(){
    // 
    return Xbox.getRawButtonPressed(RobotMap.ActuadorFrontButtonDawn);
  }
  public boolean Actuador_Front_Dawn_Released(){
    return Xbox.getRawButtonReleased(RobotMap.ActuadorFrontButtonDawn);
  }
  public boolean Actuador_Rear_Dawn_Pressed(){
    return Xbox.getRawButtonPressed(RobotMap.ActuadorRearButtonDawn);
  }
  public boolean Actuador_Rear_Dawn_Released(){
    return Xbox.getRawButtonReleased(RobotMap.ActuadorRearButtonDawn);
  }

  public double getSpeed(){
    double sliderData = getSliderData();

    // los datos de la slider vienen de -1 a 1
    if(sliderData < 0)
    {
      // convirtiendolo a positivo
      sliderData = (1.0 + sliderData);
    }
    else{
      // 1 + 0....
      sliderData = 1.0 + sliderData;
    }
    // mapeando el valor para poder pasarlo como velocidad al motor launcher
    sliderData = sliderData / 2.0;
    
    return sliderData;
  }

  public void mainEventLoop(){
    // se toman las lecturas de todos los botones para ejecutar
    // las acciones
    double sliderData = getSpeed();

    mainDrive.Drive(mStick.getY(), mStick.getX());

    //double z_axis = getZAxis();

    if(canonLauncherPressed()){
      cargoHandler.launchCargo(sliderData);
    }
    if(canonLauncherReleased()){
      cargoHandler.stopGripper();
    }
    if(canonSuckerPressed()){
      cargoHandler.takeCargo(sliderData);
    }
    if(canonSuckerReleased()){
      cargoHandler.stopGripper();
    }
    if(button_3_Pressed()){
      // elevacion del arm
      boolean neg = false;
      cargoHandler.moverArmMotor(neg);
    }
    if(button_3_Released()){
      cargoHandler.stopArmMotor();
    }
    if(button_5_Pressed()){
      // con esto va hacia abajo el arm
      boolean neg = true;
      cargoHandler.moverArmMotor(neg);
    }
    if(button_5_Released()){
      cargoHandler.stopArmMotor();
    }
    if(Compresor_Pressed()){
      compresor.start();
    }
    if(Compresor_Released())
    {
      compresor.stop();
    }
    if(mStick.getRawButtonPressed(RobotMap.explode_button)) {
      // si el boton 1 es presionado
      // s_op.direction = SolenoidOperation.Direction.FORWARD;
      hp_handler.explodeHatch();
      // System.out.println("explode");
    }
    if (mStick.getRawButtonReleased(RobotMap.explode_button)) {
      // si el boton uno es liberado
      // s_op.direction = SolenoidOperation.Direction.STOP;
      hp_handler.stopSolenoid();
    }
    if (mStick.getRawButtonPressed(RobotMap.implode_button)) {
      // si el boton 2 es presionado
      // s_op.direction = SolenoidOperation.Direction.REVERSE;
      hp_handler.implodeHatch();
      // System.out.println("implode");
    }
    if (mStick.getRawButtonReleased(RobotMap.implode_button)) {
      // si el boton 2 es liberado
      //s_op.direction = SolenoidOperation.Direction.STOP;
      hp_handler.stopSolenoid();
    if (Actuador_Fornt_UP_Pressed()){
     elevation.ActuadorFrontUp(); 
    }
    if (Actuador_Front_UP_Released()){
      elevation.ActuadorStopFront();
    }
    if (Actuador_Front_Dawn_Pressed()){
      elevation.ActuadorFrontDawn();
    }
    if (Actuador_Front_Dawn_Released()){
      elevation.ActuadorStopFront();
    }
    if (Acutuador_Rear_UP_Pessed()){
      elevation.ActuadorRearUp();
    }
    if (Actuador_Rear_UP_Released()){
      elevation.ActuadorStopRear();
    }
    if (Actuador_Rear_Dawn_Pressed()){
      elevation.ActuadorRearDawn();
    }
    if (Actuador_Rear_Dawn_Released()){
      elevation.ActuadorStopRear();
    }

    }
  }
}