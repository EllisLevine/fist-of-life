package org.teamresistance.frc;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.strongback.Strongback;
import org.strongback.SwitchReactor;
import org.strongback.command.Command;
import org.strongback.components.DistanceSensor;
import org.strongback.components.ui.FlightStick;
import org.strongback.hardware.Hardware;
import org.teamresistance.frc.command.DriveToYX;
import org.teamresistance.frc.command.HoldAngleCommand;
import org.teamresistance.frc.subsystem.drive.Drive;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Main robot class. Override methods from {@link IterativeRobot} to define behavior.
 *
 * @author Shreya Ravi
 * @author Rothanak So
 */
public class Robot extends IterativeRobot {
  private final FlightStick leftJoystick = Hardware.HumanInterfaceDevices.logitechAttack3D(0);
  private final FlightStick rightJoystick = Hardware.HumanInterfaceDevices.logitechAttack3D(1);
  private final FlightStick coJoystick = Hardware.HumanInterfaceDevices.logitechAttack3D(2);

  private final Drive drive = new Drive(
      IO.robotDrive,
      leftJoystick.getRoll(),
      leftJoystick.getPitch(),
      rightJoystick.getRoll()
  );

  @Override
  public void robotInit() {
    Strongback.configure().recordNoEvents().recordNoData().initialize();
    IO.xDistPing.setAutomaticMode(true);
    IO.yDistPing.setAutomaticMode(true);
    final SwitchReactor reactor = Strongback.switchReactor();

    // Hold the current angle of the robot while the trigger is held
//    reactor.onTriggeredSubmit(leftJoystick.getTrigger(), () -> new HoldAngleCommand(drive, 90));
//    reactor.onUntriggeredSubmit(leftJoystick.getTrigger(), () -> Command.cancel(drive));
    reactor.onTriggeredSubmit(leftJoystick.getButton(6), () -> new DriveToYX(drive,10,66,10,0));
  }

  @Override
  public void autonomousInit() {
    Strongback.start();
    // make sure these measurements are right
  }

  @Override
  public void teleopInit() {
    Strongback.start();
  }

  @Override
  public void teleopPeriodic() {
    Pose pose = new Pose(IO.gyro.getAngle(),
        IO.xDistPing.getRangeInches(),
//        IO.xDistPing.getDistanceInInches(),
        IO.yDistPing.getRangeInches());
//        IO.yDistPing.getDistanceInInches());
    SmartDashboard.putNumber("Y Distance (Ping): ", pose.yDist);
    SmartDashboard.putNumber("X Distance (Ping): ", pose.xDist);
    drive.onUpdate(pose);
  }

  @Override
  public void disabledInit() {
    Strongback.disable();
  }
}
