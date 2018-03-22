private void generate2DHeart(Level level, Vector3 pos) {

    // 心形函数️❤
    // x = 16sin^3(t)
    // y = 13cos(t)-5cos(2t)-2cos(3t)-cos(4t)

    // s ∈ [0, +∞)
    final double s = 0.8;

    ArrayList<Vector3> locations = new ArrayList<>();

    // t ∈ [0, 2π)
    for (double t = 0; t <= 2 * Math.PI; t += 0.05) {

        double x = 16 * Math.pow(Math.sin(t), 3);
        double y = 13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t);

        locations.add(new Vector3(pos.getX() + s * x, pos.getY(), pos.getZ() + s * y));
    }

    locations.forEach(loc -> level.addParticle(new HeartParticle(loc)));
}
