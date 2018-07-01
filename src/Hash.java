
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
        
        //proximaPosicao = this.getProximaPosicao(proximaPosicao); se o tamanho do mapahash nao suportar o todos os mods possiveis?
        if (this.mapa[posicao] != null) {
            while (true) {
                if (cont == this.tamanhoMapa) {
                    System.out.println("Mapa cheio!");
                    return;
                }
                proximaPosicao += ((cont * this.incremento) * (int) Math.pow(-1, controleBidirecional));
                proximaPosicao = this.getProximaPosicao(proximaPosicao);
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

    public boolean buscaChave(int chave) {
        int cont = 1;
        int controleBidirecional = 2;
        int posicao = chave % this.mod;
        int proximaPosicao = posicao;

        if ((int) this.mapa[posicao] == chave) {
            return true;
        }
        if (this.mapa[posicao] == null) {
            return false;
        }
        if (this.mapa[posicao] != null) {
            while (true) {
                if (cont == this.tamanhoMapa) {
                    return false;
                }
                proximaPosicao += ((cont * this.incremento) * (int) Math.pow(-1, controleBidirecional));
                proximaPosicao = this.getProximaPosicao(proximaPosicao);
                if ((int) mapa[proximaPosicao] == chave) {
                    return true;
                }
                cont++;
                controleBidirecional++;
            }
        } else {
            return false;
        }

    }
    
    public int getProximaPosicao(int proximaPosicao){
            while (proximaPosicao < 0 || proximaPosicao >= mapa.length) {
                    if (proximaPosicao < 0) {
                        proximaPosicao = mapa.length + proximaPosicao;
                    }
                    if (proximaPosicao >= mapa.length) {
                        proximaPosicao = Math.abs(0 + (mapa.length - proximaPosicao));
                    }
                }
        return proximaPosicao;
    }

}
