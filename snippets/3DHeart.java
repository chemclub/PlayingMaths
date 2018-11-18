private void generate3DHeart(Level level, Vector3 pos) {

    // 3D心形函数❤
    // Cartesian formula
    //(x^2+(9y^2)/4+z^2−1)^3−x^2z^3−(9y^2z^3)/80=0

    // s ∈ [0, +∞)
    final int s = 15;

    ArrayList<Vector3> locations = new ArrayList<>();

    for (double x = -1.5; x <= 1.5; x += 0.03) {
        for (double y = -1.5; y <= 1.5; y += 0.03) {
            for (double z = -1; z <= 1.5; z += 0.03) {

                if (Math.pow(Math.pow(x, 2) + (9 * Math.pow(y, 2)) / 4 + Math.pow(z, 2) - 1, 3)
                    - Math.pow(x, 2) * Math.pow(z, 3) - (9 * Math.pow(y, 2) * Math.pow(z, 3)) / 80 <= 0) {

                    locations.add(new Vector3(pos.getX() + s * x, pos.getY() + s * z, pos.getZ() + s * y));
                }
            }
        }
    }

    locations.forEach(loc -> level.setBlock(loc, new BlockWool(7)));
}
