
package ordemservico.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ordemservico.controller.ControllerOS;

/**
 *
 * @author Tiago Teixeira
 */
public class ViewOs extends javax.swing.JFrame {

    private ControllerOS controller;
    public ViewOs() {
        initComponents();
        controller = new ControllerOS();
        controller.executa(this);
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPaneSeparacao = new javax.swing.JTabbedPane();
        jPanelHistorico = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jTextFieldBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelCadastro = new javax.swing.JPanel();
        jPanelCliente = new javax.swing.JPanel();
        jTextFieldCliNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCliRG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCliCpf = new javax.swing.JFormattedTextField();
        jPanelEndCliente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCliRua = new javax.swing.JTextField();
        jTextFieldCliNumero = new javax.swing.JTextField();
        jTextFieldCliBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCliCidade = new javax.swing.JTextField();
        jTextFieldCliCep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCliEstado = new javax.swing.JTextField();
        jTextFieldCliCelular = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanelVeiculo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldVeicModelo = new javax.swing.JTextField();
        jTextFieldVeicNome = new javax.swing.JTextField();
        jTextFieldVeicMarca = new javax.swing.JTextField();
        jTextFieldVeicCor = new javax.swing.JTextField();
        jTextFieldVeicPlaca = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanelMecanico = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldNmMecanico = new javax.swing.JTextField();
        jTextFieldDataEntrega = new javax.swing.JFormattedTextField();
        jTextFieldDataChegada = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanelRelatoDefeito = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDefeito = new javax.swing.JTextArea();
        jPanelSolucao = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaSolucao = new javax.swing.JTextArea();
        jPanelPecaServCad = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldDescricaoItem = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jTextFieldValorUnItem = new javax.swing.JTextField();
        jTextFieldTotalItem = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxTipoItem = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonAddItem = new javax.swing.JButton();
        jPanelListaPecaServ = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableServPecas = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordem de Serviço - Avaliação A3");
        setIconImages(null);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 1016, 10));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Historico de Ordens de Serviço"));

        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableHistorico);

        jTextFieldBusca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });

        jLabel1.setText("Busca por Cliente e Placa de veiculo:");

        javax.swing.GroupLayout jPanelHistoricoLayout = new javax.swing.GroupLayout(jPanelHistorico);
        jPanelHistorico.setLayout(jPanelHistoricoLayout);
        jPanelHistoricoLayout.setHorizontalGroup(
            jPanelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(jTextFieldBusca)
                    .addGroup(jPanelHistoricoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelHistoricoLayout.setVerticalGroup(
            jPanelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHistoricoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneSeparacao.addTab("Historico OS", jPanelHistorico);

        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cliente"));

        jLabel2.setText("CPF");

        jLabel3.setText("Nome");

        jLabel4.setText("RG");

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClienteLayout.createSequentialGroup()
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldCliRG, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCliRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEndCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço Cliente"));

        jLabel5.setText("Rua");

        jLabel6.setText("Número");

        jLabel7.setText("Bairro");

        jLabel8.setText("Cidade");

        jTextFieldCliCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCliCepActionPerformed(evt);
            }
        });

        jLabel9.setText("Cep");

        jLabel10.setText("Estado");

        jLabel11.setText("Celular");

        javax.swing.GroupLayout jPanelEndClienteLayout = new javax.swing.GroupLayout(jPanelEndCliente);
        jPanelEndCliente.setLayout(jPanelEndClienteLayout);
        jPanelEndClienteLayout.setHorizontalGroup(
            jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldCliRua, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldCliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldCliCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelEndClienteLayout.setVerticalGroup(
            jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, 0)
                        .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEndClienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldCliRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(0, 0, 0)
                .addGroup(jPanelEndClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCliCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Veiculo"));

        jLabel12.setText("Nome");

        jTextFieldVeicMarca.setText(" ");

        jLabel13.setText("Modelo");

        jLabel14.setText("Marca");

        jLabel15.setText("Placa");

        jLabel16.setText("Cor");

        javax.swing.GroupLayout jPanelVeiculoLayout = new javax.swing.GroupLayout(jPanelVeiculo);
        jPanelVeiculo.setLayout(jPanelVeiculoLayout);
        jPanelVeiculoLayout.setHorizontalGroup(
            jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVeicNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(40, 40, 40)
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVeicModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVeicMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(50, 50, 50)
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVeicCor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(63, 63, 63)
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVeicPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(25, 25, 25))
        );
        jPanelVeiculoLayout.setVerticalGroup(
            jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculoLayout.createSequentialGroup()
                .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addGroup(jPanelVeiculoLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(0, 0, 0)
                        .addGroup(jPanelVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldVeicNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVeicModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVeicMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVeicCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVeicPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );

        jPanelMecanico.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Mecanico"));

        jLabel17.setText("Nome Mecanico");

        jLabel18.setText("Data Chegada");

        jLabel19.setText("Data Entrega");

        javax.swing.GroupLayout jPanelMecanicoLayout = new javax.swing.GroupLayout(jPanelMecanico);
        jPanelMecanico.setLayout(jPanelMecanicoLayout);
        jPanelMecanicoLayout.setHorizontalGroup(
            jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMecanicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNmMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(52, 52, 52)
                .addGroup(jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelMecanicoLayout.setVerticalGroup(
            jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMecanicoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGroup(jPanelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNmMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRelatoDefeito.setBorder(javax.swing.BorderFactory.createTitledBorder("Defeito Relatado"));

        jTextAreaDefeito.setColumns(20);
        jTextAreaDefeito.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDefeito);

        javax.swing.GroupLayout jPanelRelatoDefeitoLayout = new javax.swing.GroupLayout(jPanelRelatoDefeito);
        jPanelRelatoDefeito.setLayout(jPanelRelatoDefeitoLayout);
        jPanelRelatoDefeitoLayout.setHorizontalGroup(
            jPanelRelatoDefeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelatoDefeitoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelRelatoDefeitoLayout.setVerticalGroup(
            jPanelRelatoDefeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelatoDefeitoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanelSolucao.setBorder(javax.swing.BorderFactory.createTitledBorder("Solução Encontrada"));

        jTextAreaSolucao.setColumns(20);
        jTextAreaSolucao.setRows(5);
        jScrollPane3.setViewportView(jTextAreaSolucao);

        javax.swing.GroupLayout jPanelSolucaoLayout = new javax.swing.GroupLayout(jPanelSolucao);
        jPanelSolucao.setLayout(jPanelSolucaoLayout);
        jPanelSolucaoLayout.setHorizontalGroup(
            jPanelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanelSolucaoLayout.setVerticalGroup(
            jPanelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSolucaoLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanelPecaServCad.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro Peça / Serviço"));

        jLabel20.setText("Descrição");

        jLabel21.setText("Quantidade");

        jLabel22.setText("Valor Un");

        jTextFieldValorUnItem.setText("R$0,00");
        jTextFieldValorUnItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValorUnItemFocusLost(evt);
            }
        });
        jTextFieldValorUnItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorUnItemKeyPressed(evt);
            }
        });

        jTextFieldTotalItem.setText("R$0,00");

        jLabel23.setText("Valor Total");

        jComboBoxTipoItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SERVICO", "PECA" }));

        jLabel24.setText("jLabel24");

        jLabel25.setText("Tipo Item");

        jButtonAddItem.setText("Adicionar");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPecaServCadLayout = new javax.swing.GroupLayout(jPanelPecaServCad);
        jPanelPecaServCad.setLayout(jPanelPecaServCadLayout);
        jPanelPecaServCadLayout.setHorizontalGroup(
            jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescricaoItem)
                    .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                        .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jTextFieldValorUnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jTextFieldTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTipoItem, javax.swing.GroupLayout.Alignment.TRAILING, 0, 119, Short.MAX_VALUE)
                                    .addComponent(jLabel25)
                                    .addComponent(jButtonAddItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanelPecaServCadLayout.setVerticalGroup(
            jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescricaoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(0, 0, 0)
                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelPecaServCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jComboBoxTipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25)))
                    .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPecaServCadLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldValorUnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelListaPecaServ.setBorder(javax.swing.BorderFactory.createTitledBorder("Listagem Peça e Serviço"));

        jTableServPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableServPecas);

        javax.swing.GroupLayout jPanelListaPecaServLayout = new javax.swing.GroupLayout(jPanelListaPecaServ);
        jPanelListaPecaServ.setLayout(jPanelListaPecaServLayout);
        jPanelListaPecaServLayout.setHorizontalGroup(
            jPanelListaPecaServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListaPecaServLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanelListaPecaServLayout.setVerticalGroup(
            jPanelListaPecaServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaPecaServLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelVeiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelEndCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelMecanico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRelatoDefeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jPanelPecaServCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelListaPecaServ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanelEndCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRelatoDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPecaServCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelListaPecaServ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneSeparacao.addTab("Cadastro OS", jPanelCadastro);

        jPanel1.add(jTabbedPaneSeparacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 91, -1, 701));

        jButtonNovo.setText("NOVO");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 90, 63));

        jButtonExcluir.setText("EXCLUIR");
        jPanel1.add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 6, 90, 63));

        jButtonGravar.setText("GRAVAR");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 6, 90, 63));

        jButtonImprimir.setText("IMPRIMIR");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 90, 63));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        controller.jButtonGravar();
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTextFieldCliCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCliCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCliCepActionPerformed

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyReleased
        controller.jTextFiltroTabela();
    }//GEN-LAST:event_jTextFieldBuscaKeyReleased

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        controller.jButtonNovo();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        controller.jButtonAdd();
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jTextFieldValorUnItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorUnItemFocusLost
        controller.jTextValorUn();
    }//GEN-LAST:event_jTextFieldValorUnItemFocusLost

    private void jTextFieldValorUnItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorUnItemKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            controller.jTextValorUn();
        }
    }//GEN-LAST:event_jTextFieldValorUnItemKeyPressed

    public JButton getjButtonAddItem() {
        return jButtonAddItem;
    }

    public void setjButtonAddItem(JButton jButtonAddItem) {
        this.jButtonAddItem = jButtonAddItem;
    }

    public JButton getjButtonExcluir() {
        return jButtonExcluir;
    }

    public void setjButtonExcluir(JButton jButtonExcluir) {
        this.jButtonExcluir = jButtonExcluir;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public void setjButtonGravar(JButton jButtonGravar) {
        this.jButtonGravar = jButtonGravar;
    }

    public JButton getjButtonImprimir() {
        return jButtonImprimir;
    }

    public void setjButtonImprimir(JButton jButtonImprimir) {
        this.jButtonImprimir = jButtonImprimir;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public void setjButtonNovo(JButton jButtonNovo) {
        this.jButtonNovo = jButtonNovo;
    }

    public JComboBox<String> getjComboBoxTipoItem() {
        return jComboBoxTipoItem;
    }

    public void setjComboBoxTipoItem(JComboBox<String> jComboBoxTipoItem) {
        this.jComboBoxTipoItem = jComboBoxTipoItem;
    }

    public JTabbedPane getjTabbedPaneSeparacao() {
        return jTabbedPaneSeparacao;
    }

    public void setjTabbedPaneSeparacao(JTabbedPane jTabbedPaneSeparacao) {
        this.jTabbedPaneSeparacao = jTabbedPaneSeparacao;
    }

    public JTable getjTableHistorico() {
        return jTableHistorico;
    }

    public void setjTableHistorico(JTable jTableHistorico) {
        this.jTableHistorico = jTableHistorico;
    }

    public JTable getjTableServPecas() {
        return jTableServPecas;
    }

    public void setjTableServPecas(JTable jTableServPecas) {
        this.jTableServPecas = jTableServPecas;
    }

    public JTextArea getjTextAreaDefeito() {
        return jTextAreaDefeito;
    }

    public void setjTextAreaDefeito(JTextArea jTextAreaDefeito) {
        this.jTextAreaDefeito = jTextAreaDefeito;
    }

    public JTextArea getjTextAreaSolucao() {
        return jTextAreaSolucao;
    }

    public void setjTextAreaSolucao(JTextArea jTextAreaSolucao) {
        this.jTextAreaSolucao = jTextAreaSolucao;
    }

    public JTextField getjTextFieldBusca() {
        return jTextFieldBusca;
    }

    public void setjTextFieldBusca(JTextField jTextFieldBusca) {
        this.jTextFieldBusca = jTextFieldBusca;
    }

    public JTextField getjTextFieldCliBairro() {
        return jTextFieldCliBairro;
    }

    public void setjTextFieldCliBairro(JTextField jTextFieldCliBairro) {
        this.jTextFieldCliBairro = jTextFieldCliBairro;
    }

    public JTextField getjTextFieldCliCep() {
        return jTextFieldCliCep;
    }

    public void setjTextFieldCliCep(JTextField jTextFieldCliCep) {
        this.jTextFieldCliCep = jTextFieldCliCep;
    }

    public JTextField getjTextFieldCliCidade() {
        return jTextFieldCliCidade;
    }

    public void setjTextFieldCliCidade(JTextField jTextFieldCliCidade) {
        this.jTextFieldCliCidade = jTextFieldCliCidade;
    }

    public JFormattedTextField getjTextFieldCliCpf() {
        return jTextFieldCliCpf;
    }

    public void setjTextFieldCliCpf(JFormattedTextField jTextFieldCliCpf) {
        this.jTextFieldCliCpf = jTextFieldCliCpf;
    }

    public JTextField getjTextFieldCliEstado() {
        return jTextFieldCliEstado;
    }

    public void setjTextFieldCliEstado(JTextField jTextFieldCliEstado) {
        this.jTextFieldCliEstado = jTextFieldCliEstado;
    }

    public JTextField getjTextFieldCliRG() {
        return jTextFieldCliRG;
    }

    public void setjTextFieldCliRG(JTextField jTextFieldCliRG) {
        this.jTextFieldCliRG = jTextFieldCliRG;
    }

    public JTextField getjTextFieldCliRua() {
        return jTextFieldCliRua;
    }

    public void setjTextFieldCliRua(JTextField jTextFieldCliRua) {
        this.jTextFieldCliRua = jTextFieldCliRua;
    }

    public JFormattedTextField getjTextFieldDataChegada() {
        return jTextFieldDataChegada;
    }

    public void setjTextFieldDataChegada(JFormattedTextField jTextFieldDataChegada) {
        this.jTextFieldDataChegada = jTextFieldDataChegada;
    }

    public JFormattedTextField getjTextFieldDataEntrega() {
        return jTextFieldDataEntrega;
    }

    public void setjTextFieldDataEntrega(JFormattedTextField jTextFieldDataEntrega) {
        this.jTextFieldDataEntrega = jTextFieldDataEntrega;
    }

    public JTextField getjTextFieldDescricaoItem() {
        return jTextFieldDescricaoItem;
    }

    public void setjTextFieldDescricaoItem(JTextField jTextFieldDescricaoItem) {
        this.jTextFieldDescricaoItem = jTextFieldDescricaoItem;
    }

    public JTextField getjTextFieldNmMecanico() {
        return jTextFieldNmMecanico;
    }

    public void setjTextFieldNmMecanico(JTextField jTextFieldNmMecanico) {
        this.jTextFieldNmMecanico = jTextFieldNmMecanico;
    }

    public JTextField getjTextFieldQtd() {
        return jTextFieldQtd;
    }

    public void setjTextFieldQtd(JTextField jTextFieldQtd) {
        this.jTextFieldQtd = jTextFieldQtd;
    }

    public JTextField getjTextFieldTotalItem() {
        return jTextFieldTotalItem;
    }

    public void setjTextFieldTotalItem(JTextField jTextFieldTotalItem) {
        this.jTextFieldTotalItem = jTextFieldTotalItem;
    }

    public JTextField getjTextFieldValorUnItem() {
        return jTextFieldValorUnItem;
    }

    public void setjTextFieldValorUnItem(JTextField jTextFieldValorUnItem) {
        this.jTextFieldValorUnItem = jTextFieldValorUnItem;
    }

    public JTextField getjTextFieldVeicCor() {
        return jTextFieldVeicCor;
    }

    public void setjTextFieldVeicCor(JTextField jTextFieldVeicCor) {
        this.jTextFieldVeicCor = jTextFieldVeicCor;
    }

    public JTextField getjTextFieldVeicMarca() {
        return jTextFieldVeicMarca;
    }

    public void setjTextFieldVeicMarca(JTextField jTextFieldVeicMarca) {
        this.jTextFieldVeicMarca = jTextFieldVeicMarca;
    }

    public JTextField getjTextFieldVeicModelo() {
        return jTextFieldVeicModelo;
    }

    public void setjTextFieldVeicModelo(JTextField jTextFieldVeicModelo) {
        this.jTextFieldVeicModelo = jTextFieldVeicModelo;
    }

    public JTextField getjTextFieldVeicNome() {
        return jTextFieldVeicNome;
    }

    public void setjTextFieldVeicNome(JTextField jTextFieldVeicNome) {
        this.jTextFieldVeicNome = jTextFieldVeicNome;
    }

    public JTextField getjTextFieldVeicPlaca() {
        return jTextFieldVeicPlaca;
    }

    public void setjTextFieldVeicPlaca(JTextField jTextFieldVeicPlaca) {
        this.jTextFieldVeicPlaca = jTextFieldVeicPlaca;
    }

    public JFormattedTextField getjTextFieldCliCelular() {
        return jTextFieldCliCelular;
    }

    public void setjTextFieldCliCelular(JFormattedTextField jTextFieldCliCelular) {
        this.jTextFieldCliCelular = jTextFieldCliCelular;
    }

    public JTextField getjTextFieldCliNome() {
        return jTextFieldCliNome;
    }

    public void setjTextFieldCliNome(JTextField jTextFieldCliNome) {
        this.jTextFieldCliNome = jTextFieldCliNome;
    }

    public JTextField getjTextFieldCliNumero() {
        return jTextFieldCliNumero;
    }

    public void setjTextFieldCliNumero(JTextField jTextFieldCliNumero) {
        this.jTextFieldCliNumero = jTextFieldCliNumero;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox<String> jComboBoxTipoItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelEndCliente;
    private javax.swing.JPanel jPanelHistorico;
    private javax.swing.JPanel jPanelListaPecaServ;
    private javax.swing.JPanel jPanelMecanico;
    private javax.swing.JPanel jPanelPecaServCad;
    private javax.swing.JPanel jPanelRelatoDefeito;
    private javax.swing.JPanel jPanelSolucao;
    private javax.swing.JPanel jPanelVeiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPaneSeparacao;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTable jTableServPecas;
    private javax.swing.JTextArea jTextAreaDefeito;
    private javax.swing.JTextArea jTextAreaSolucao;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldCliBairro;
    private javax.swing.JFormattedTextField jTextFieldCliCelular;
    private javax.swing.JTextField jTextFieldCliCep;
    private javax.swing.JTextField jTextFieldCliCidade;
    private javax.swing.JFormattedTextField jTextFieldCliCpf;
    private javax.swing.JTextField jTextFieldCliEstado;
    private javax.swing.JTextField jTextFieldCliNome;
    private javax.swing.JTextField jTextFieldCliNumero;
    private javax.swing.JTextField jTextFieldCliRG;
    private javax.swing.JTextField jTextFieldCliRua;
    private javax.swing.JFormattedTextField jTextFieldDataChegada;
    private javax.swing.JFormattedTextField jTextFieldDataEntrega;
    private javax.swing.JTextField jTextFieldDescricaoItem;
    private javax.swing.JTextField jTextFieldNmMecanico;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldTotalItem;
    private javax.swing.JTextField jTextFieldValorUnItem;
    private javax.swing.JTextField jTextFieldVeicCor;
    private javax.swing.JTextField jTextFieldVeicMarca;
    private javax.swing.JTextField jTextFieldVeicModelo;
    private javax.swing.JTextField jTextFieldVeicNome;
    private javax.swing.JTextField jTextFieldVeicPlaca;
    // End of variables declaration//GEN-END:variables
}
