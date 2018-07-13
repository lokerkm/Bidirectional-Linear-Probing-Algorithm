
import java.util.ArrayList;


public class Hash {

    private int tamanhoMapa;
    private Object mapa[];
    private int incremento;
    private ArrayList<Object> historicoInsercao = new ArrayList();
    //private int controleBidirecional = 2;

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

        if (this.buscaChave(chave) != null) { //se ja existir a chave, nao insere
            return;
        }
        if (this.mapa[posicao] != null) {
            if (this.incremento < 0) {
                controleBidirecional += 1;

            }
            while (true) {
                if (cont == this.tamanhoMapa) {
                    System.out.println("Mapa cheio!");
                    return;
                }
                proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
                if (mapa[proximaPosicao] == null) {
                    posicao = proximaPosicao;
                    break;
                }
                cont++;
                controleBidirecional++;
            }
        }
        this.historicoInsercao.add(chave);
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
            if (this.incremento < 0) {
                controleBidirecional += 1;

            }
            while (true) {
                if (cont == this.tamanhoMapa) {
                    return null;
                }

                proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
                if (mapa[proximaPosicao] == null) {
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

    public int getProximaPosicao(int proximaPosicao, int cont, int controleBidirecional) {
        proximaPosicao += ((cont * Math.abs(this.incremento)) * (int) Math.pow(-1, controleBidirecional));
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

// void removeChave(int chave) {
//        int cont = 1;
//        int controleBidirecional = 2;
//        if (this.buscaChave(chave) == null) {
//            return;
//        }
//        int posicao = this.buscaChave(chave);
//        int teste = 0;
//        this.mapa[posicao] = null;
//        int posicaoAnterior = chave % tamanhoMapa;
//        posicao = this.getProximaPosicao(posicaoAnterior, cont, controleBidirecional);
//        cont++;
//        controleBidirecional++;
//        int proximaPosicao = this.getProximaPosicao(posicao, cont, controleBidirecional);
//        cont++;
//        controleBidirecional++;
//
//        if (this.mapa[posicao] == null && this.mapa[proximaPosicao] == null) {
//            return;
//        }
//        if (this.mapa[proximaPosicao] != null) { //ant = qualquer, atual = null e prox = qualquer
//            if (this.mapa[posicao] == null) {
//                if (proximaPosicao == (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                    posicaoAnterior = posicao;
//                    posicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                    proximaPosicao = this.getProximaPosicao(posicao, cont, controleBidirecional);
//                }
//                if (proximaPosicao != (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                    this.mapa[posicao] = (int) this.mapa[proximaPosicao];
//                    this.mapa[proximaPosicao] = null;
//                    posicaoAnterior = posicao;
//                    posicao = proximaPosicao;
//                    proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                }
//
//            }
//        }
//        if (this.mapa[posicao] != null) { // ant =null, atual = qualquer, prox = qualquer
//            if (this.mapa[posicaoAnterior] == null) {
//                if (posicao == (int) this.mapa[posicao] % this.tamanhoMapa) {
//                    posicao = proximaPosicao;
//                    proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                }
//                if (posicao != (int) this.mapa[posicao] % this.tamanhoMapa) {
//                    this.mapa[posicaoAnterior] = (int) this.mapa[posicao];
//                    this.mapa[posicao] = null;
//                    posicaoAnterior = posicao;
//                    posicao = proximaPosicao;
//                    proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                }
//
//            }
//
//        }
//        if (this.mapa[proximaPosicao] != null) {// ant= qualquer, atual= qualquer, prox= null
//            if (this.mapa[posicao] == null) {
//                if (proximaPosicao == (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                    proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//
//                }
//                if (proximaPosicao != (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                    this.mapa[posicao] = (int) this.mapa[proximaPosicao];
//                    this.mapa[proximaPosicao] = null;
//                    posicaoAnterior = posicao;
//                    posicao = proximaPosicao;
//                    proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                }
//
//            }
//        }
//
//        if (this.mapa[proximaPosicao] != null) {
////            posicaoAnterior = proximaPosicao;
////            proximaPosicao = this.getProximaPosicao(proximaPosicao);
//            while (teste <= this.mapa.length) {
////                if (cont == this.tamanhoMapa) { nao vai precisar, pq ja procura a chave antes
////                    return null;
////                }
//                if (this.mapa[proximaPosicao] != null) { //ant = qualquer, atual = null e prox = qualquer
//                    if (this.mapa[posicao] == null) {
//                        
//                        if (proximaPosicao == (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                            posicaoAnterior = posicao;
//                            posicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                            proximaPosicao = this.getProximaPosicao(posicao, cont, controleBidirecional);
//                        }
//                        if (proximaPosicao != (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                            this.mapa[posicao] = (int) this.mapa[proximaPosicao];
//                            this.mapa[proximaPosicao] = null;
//                            posicaoAnterior = posicao;
//                            posicao = proximaPosicao;
//                            proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                        }
//                        
//
//                    }
//                }
//                if (this.mapa[posicao] != null) { // ant =null, atual = qualquer, prox = qualquer
//                    if (this.mapa[posicaoAnterior] == null) {
//                        if (posicao != (int) this.mapa[posicao] % this.tamanhoMapa) {
//                            this.mapa[posicaoAnterior] = (int) this.mapa[posicao];
//                            this.mapa[posicao] = null;
//                            posicaoAnterior = posicao;
//                            posicao = proximaPosicao;
//                            proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                        }
//                        if (posicao == (int) this.mapa[posicao] % this.tamanhoMapa) {
//                            posicao = proximaPosicao;
//                            proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                        }
//                        
//
//                    }
//
//                }
//                if (this.mapa[proximaPosicao] != null) {// ant= qualquer, atual= qualquer, prox= null
//                    if (proximaPosicao != (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                            this.mapa[posicao] = (int) this.mapa[proximaPosicao];
//                            this.mapa[proximaPosicao] = null;
//                            posicaoAnterior = posicao;
//                            posicao = proximaPosicao;
//                            proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//                        }
//                    if (this.mapa[posicao] == null) {
//                        if (proximaPosicao == (int) this.mapa[proximaPosicao] % this.tamanhoMapa) {
//                            proximaPosicao = this.getProximaPosicao(proximaPosicao, cont, controleBidirecional);
//
//                        }
//                        
//
//                    }
//                }
//
//
//                teste++;
//                cont++;
//                controleBidirecional++;
//            }
//        } else {
//            return;
//        }
//
//    }

    public int quantidadeChaves() {
        int qnt = 0;
        for (int i = 0; i < this.mapa.length; i++) {
            if (this.mapa[i] != null) {
                qnt += 1;
            }
        }
        return qnt;
    }

    public void removeChaveReinsercao(int chave){
        if (this.buscaChave(chave) == null) {
            return;
        }
        int posicao = this.buscaChave(chave);
        this.historicoInsercao.remove((Object) chave);
        for (int i = 0; i < this.mapa.length; i++) {
            this.mapa[i] = null;
        }
        for (int i = 0; i < this.historicoInsercao.size(); i++) {
            this.insereChave((int) this.historicoInsercao.get(i));
        }
    }

}
