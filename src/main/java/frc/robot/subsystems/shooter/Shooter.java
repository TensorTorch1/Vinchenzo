package frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.components.hardware.OutputComponent;

public class Shooter extends SubsystemBase {
    private OutputComponent shooterMotor;
    public Shooter(OutputComponent s1) {
        shooterMotor = s1;
    }

    public void setSpeed(double speed) {
        shooterMotor.setOutput(speed);
    }

    public double getSpeed() {
        return shooterMotor.getOutput();
    }

}
