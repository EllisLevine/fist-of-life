package org.teamresistance.frc;

import edu.wpi.first.wpilibj.Ultrasonic;
import org.strongback.components.Motor;
import org.strongback.drive.MecanumDrive;
import org.strongback.hardware.Hardware;

import edu.wpi.first.wpilibj.SPI;

/**
 * @author Shreya Ravi
 */
public class IO {
  public static final Motor frontLeftMotor = Hardware.Motors.victor(0);
  public static final Motor frontRightMotor = Hardware.Motors.victor(1).invert();
  public static final Motor rearLeftMotor = Hardware.Motors.victor(2);
  public static final Motor rearRightMotor = Hardware.Motors.victor(3).invert();

  public static final Gyro3D gyro = new Gyro3D(SPI.Port.kMXP);

  public static final MecanumDrive robotDrive = new MecanumDrive(
      frontLeftMotor,
      rearLeftMotor,
      frontRightMotor,
      rearRightMotor,
      gyro
  );

  public static final Ping xDistSensor = new Ping(0,1);
  public static final Ping yDistSensor = new Ping(2,3);

}
