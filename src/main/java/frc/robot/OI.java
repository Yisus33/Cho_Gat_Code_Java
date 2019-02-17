/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
public class OI {
  // Definimos una instancia de joylstic
  public Joystick mStick;

  public OI()
  {
  // constructor
    mStick = new Joystick(RobotMap.ACTUAL_USB_PORT);
  }
  
  public double getSliderData()
  {
    return mStick.getRawAxis(RobotMap.SLIDER_PORT);
  }
  
  public boolean canonLauncherPressed()
  {
    return mStick.getRawButtonPressed(RobotMap.LAUNCHER_BUTTON_NUMBER);
  }

  public boolean canonSuckerPressed()
  {
    return mStick.getRawButtonPressed(RobotMap.SUCKER_BUTTON_NUMBER);
  }

  public boolean button_5_Pressed()
  {
    return mStick.getRawButtonPressed(RobotMap.BUTTON_PORT_5);
  }

  public boolean button_3_Pressed()
  {
    return mStick.getRawButtonPressed(RobotMap.BUTTON_PORT_3);
  }
}
