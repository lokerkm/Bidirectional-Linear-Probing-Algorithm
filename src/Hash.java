
public class Hash {

    private int tamanhoMapa;
    private Object mapa[];
    private int mod;
    private int incremento;

    public Hash(int tamanhoMapa, int mod, int imcremento) {
        this.tamanhoMapa = tamanhoMapa;
        this.mod = mod;
        this.incremento = imcremento;
        this.mapa = new Object[tamanhoMapa];
    }

    public int getTamanhoMapa() {
        return tamanhoMapa;
    }

    public void setTamanhoMapa(int tamanhoMapa) {
        this.tamanhoMapa = tamanhoMapa;
    }

    public Object[] getMapa() {
        return mapa;
    }

    public void setMapa(Object[] mapa) {
        this.mapa = mapa;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public void insereChave(int chave) {
        int cont = 1;
        int controleBidirecional = 2;
        int posicao = chave % this.mod;
        int proximaPosicao = posicao;

        if (this.mapa[posicao] != null) {
            while (true) {
                proximaPosicao += ((cont * this.incremento) * (int) Math.pow(-1, controleBidirecional));
                while (proximaPosicao < 0 || proximaPosicao > mapa.length) {
                    if (proximaPosicao < 0) {
                        proximaPosicao = mapa.length + proximaPosicao;
                    }
                    if (proximaPosicao > mapa.length) {
                        proximaPosicao = 0 + (mapa.length - proximaPosicao);
                    }
                }
                if (mapa[proximaPosicao] == null) {
                    posicao = proximaPosicao;
                    break;
                }
                cont++;
                controleBidirecional++;
            }
        }
        this.mapa[posicao] = chave;

    }

}
