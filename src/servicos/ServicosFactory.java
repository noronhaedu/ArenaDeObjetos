package servicos;

public class ServicosFactory {
    private static VitimaServicos vitimaS = new VitimaServicos();

    public static VitimaServicos getVitimaServicos() {
        return vitimaS;
    }

    private static GuerreiroServicos guerreiroS = new GuerreiroServicos();

    public static GuerreiroServicos getGuerreiroServicos() {
        return guerreiroS;
    }

    private static LadraoServicos ladraoS = new LadraoServicos();

    public static LadraoServicos getLadraoServicos() {
        return ladraoS;
    }
}
