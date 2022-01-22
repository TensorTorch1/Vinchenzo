package frc.robot.subsystems.shooter;

import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.components.DoubleAngularVelocityComponent;
import frc.robot.components.hardware.SparkMaxComponent;

public class HardwareShooterFactory {
    public static Shooter makeShooter(){
        SparkMaxComponent m1 = new SparkMaxComponent(1, CANSparkMaxLowLevel.MotorType.kBrushless);
        SparkMaxComponent m2 = new SparkMaxComponent(2, CANSparkMaxLowLevel.MotorType.kBrushless);
        /**
         * One motor NEEDS to be inverted! The shooter motors turn in opposite directions
         * If they go the same directions, the shooter will explode.
         */
        m2.setInverted(true);
        DoubleAngularVelocityComponent motors = new DoubleAngularVelocityComponent(m1, m2);
        return new Shooter(motors);
    }
}
