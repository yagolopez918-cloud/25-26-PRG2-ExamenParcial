class Ticket {

    private String horaEntrada;
    private String horaSalida;
    private boolean activo;

    public Ticket(String horaEntrada) {
        this.horaEntrada = horaEntrada;
        this.activo = true;
    }

    public String obtenerHoraEntrada() {
        return horaEntrada;
    }

    public String obtenerHoraSalida() {
        return horaSalida;
    }

    public void registrarSalida(String horaSalida) {
        this.horaSalida = horaSalida;
        this.activo = false;
    }

    public boolean estaActivo() {
        return activo;
    }

    public double calcularTarifa() {
        return 10.0; 
    }
}



class Vehiculo {

    private String matricula;
    private String tipo;
    private String modelo;
    private Ticket ticket;

    public Vehiculo(String matricula, String tipo, String modelo) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public String obtenerMatricula() {
        return matricula;
    }

    public String obtenerTipo() {
        return tipo;
    }

    public String obtenerModelo() {
        return modelo;
    }

    public void asignarTicket(Ticket t) {
        this.ticket = t;
    }

    public Ticket obtenerTicket() {
        return ticket;
    }
}

class Aparcamiento {

    private Vehiculo[] vehiculos;
    private Ticket[] tickets;
    private int contador;

    public Aparcamiento(int capacidad) {
        vehiculos = new Vehiculo[capacidad];
        tickets = new Ticket[capacidad];
        contador = 0;
    }

    public void registrarEntrada(Vehiculo v, String horaEntrada) {
        Ticket t = new Ticket(horaEntrada);
        v.asignarTicket(t);

        vehiculos[contador] = v;
        tickets[contador] = t;
        contador++;
    }

    public void registrarSalida(Vehiculo v, String horaSalida) {
        Ticket t = v.obtenerTicket();
        t.registrarSalida(horaSalida);

        double precio = t.calcularTarifa();
        System.out.println("Precio: " + precio);
    }

    public int plazasDisponibles() {
        return vehiculos.length - contador;
    }

    public Ticket[] obtenerTicketsActivos() {
        Ticket[] activos = new Ticket[contador];
        int j = 0;

        for (int i = 0; i < contador; i++) {
            if (tickets[i].estaActivo()) {
                activos[j] = tickets[i];
                j++;
            }
        }

        return activos;
    }
}