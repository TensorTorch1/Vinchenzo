package frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.components.AngularVelocityComponent;

public class Shooter extends SubsystemBase {
    private AngularVelocityComponent shooterMotor;
    public Shooter(AngularVelocityComponent s1) {
        shooterMotor = s1;
    }

    public void setSpeed(double speed) {
        shooterMotor.setAngularVelocity(speed);
    }

    public double getSpeed() {
        return shooterMotor.getAngularVelocity();
    }

}
