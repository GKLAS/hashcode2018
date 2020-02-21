import java.io.File;

class Main {

    public static void main(String[] args) {
        String[] examples = {"a_example", "b_should_be_easy", "c_no_hurry", "d_metropolis", "e_high_bonus"};
        int total = 0;
        new File("outputs").mkdirs();

        Simulation sim = new GreedySimulation();
        for (String filename : examples) {
            total += sim.run("inputs/" + filename + ".in", "outputs/" + filename + ".out");
        }
        System.out.println(total);
    }
}
