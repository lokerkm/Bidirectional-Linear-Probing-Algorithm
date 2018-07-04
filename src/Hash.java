
public class Hash {

    private int tamanhoMapa;
    private Object mapa[];
    private int incremento;
    private int controleBidirecional = 2;

    public Hash(int tamanhoMapa, int imcremento) {
        this.tamanhoMapa = tamanhoMapa;
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

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public void insereChave(int chave) {
        int cont = 1;
        int controleBidirecional = 2;
        int posicao = chave % this.tamanhoMapa;
        int proximaPosicao = posicao;
        
        if(this.buscaChave(chave) != null){
            return;
        }
        if (this.mapa[posicao] != null) {
            while (true) {
                if (cont == this.tamanhoMapa) {
                    System.out.println("Mapa cheio!");
                    return;
                }
                proximaPosicao = this.getProximaPosicao(proximaPosicao,cont);
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

    public Integer buscaChave(int chave) {
        int cont = 1;
        int controleBidirecional = 2;
        int posicao = chave % this.tamanhoMapa;
        int proximaPosicao = posicao;

        if (this.mapa[posicao] == null) {
            return null;
        }
        if ((int) this.mapa[posicao] == chave) {
            return posicao;
        }
        
        if (this.mapa[posicao] != null) {
            while (true) {
                if (cont == this.tamanhoMapa) {
                    return null;
                }
                
                proximaPosicao = this.getProximaPosicao(proximaPosicao,cont);
                if ( mapa[proximaPosicao] == null) {
                    return null;
                }
                if ((int) mapa[proximaPosicao] == chave) {
                    return proximaPosicao;
                }
                
                cont++;
                controleBidirecional++;
            }
        } else {
            return null;
        }

    }
    
    public int getProximaPosicao(int proximaPosicao, int cont){
        proximaPosicao += ((cont * this.incremento) * (int) Math.pow(-1, this.controleBidirecional));
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

    void removeChave(int chave){
        int cont = 1;
        int controleBidirecional = 2;
        if(this.buscaChave(chave) == null){
            return;
        }
        int posicao = this.buscaChave(chave);
        this.mapa[posicao] = null;
        int posicaoAnterior = chave % tamanhoMapa;
        posicao = this.getProximaPosicao(posicaoAnterior, cont);
        cont++;
        int proximaPosicao = this.getProximaPosicao(posicao,cont);
        cont++;
//        if(this.mapa[posicao] == null){
//         return;
//        }
        
        if(this.mapa[posicaoAnterior] == null && posicao != (int) this.mapa[posicao] % this.tamanhoMapa){
            this.mapa[posicaoAnterior] = (int) this.mapa[posicao];
            this.mapa[posicao] = null;
        }

        
         if (this.mapa[proximaPosicao] != null) {
//            posicaoAnterior = proximaPosicao;
//            proximaPosicao = this.getProximaPosicao(proximaPosicao);
            while (true) {
//                if (cont == this.tamanhoMapa) { nao vai precisar, pq ja procura a chave antes
//                    return null;
//                }
                
                if(proximaPosicao != (int) this.mapa[proximaPosicao] % this.tamanhoMapa && this.mapa[posicao] == null){
                    this.mapa[posicao] =(int) this.mapa[proximaPosicao];
                    this.mapa[proximaPosicao] = null;
                }
                posicaoAnterior = posicao;
                posicao = proximaPosicao;
                proximaPosicao = this.getProximaPosicao(proximaPosicao, cont);
                
                
                
                
                if(this.mapa[proximaPosicao] == null){
                return;
                }
                
                cont++;
                controleBidirecional++;
            }
        } else {
           return;
        }
        
        
        
    }
    
//    public boolean confirmaPosicao(int chave, int posicao){
//        if(posicao == (int) this.mapa[posicao] % this.tamanhoMapa)
//    }
}
