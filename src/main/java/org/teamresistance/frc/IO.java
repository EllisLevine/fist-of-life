package org.teamresistance.frc;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
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
  //  private static final DistanceSensor xDistPing = Hardware.DistanceSensors.digitalUltrasonic(0,1);
  //  private static final DistanceSensor yDistPing = Hardware.DistanceSensors.digitalUltrasonic(2,3);
  public static final Ultrasonic xDistPing = new Ultrasonic(0,1);
  public static final Ultrasonic yDistPing = new Ultrasonic(2,3);

  // Victors instantiations for the shooter
  public static final Victor GREEN_SPINNER = new Victor(6);
  public static final Victor ORANGE_SPINNER = new Victor(7);
}

