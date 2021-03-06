# SysMatricula

Sistema de verificação de Matrícula
==============================

O Sistema de Verificação de Matricula, doravante denominado simplesmente SYSMATRICULA, tem por finalidade verificar uma serie de matrículas da empresa XPTO.
As matrículas armazenadas em lote (arquivo em formato texto) e separadas com quebra de linha, sendo a divisão de matrículas indicada pela mudança de linha, serão verificadas da seguinte maneira:
* As matriculas que não houverem dígito verificador terão este gerado automaticamente.
* As matrículas que possuírem o dígito verificador serão autenticadas, acusando se está correto ou não.


Especificações Técnicas
--------------------------------

Requisitos do sistema:

-Sistema requerido:
-Instalação do Java versão 6 ou posterior

- Sistema Operacional:
- Windows XP ou posterior (32 e 64 bits)
- Linux com Kernel 3.10 ou posterior (32 e 64 bits)
- Mac OS X 10.6 Snow Leopard ou posterior

-Tipo de CPU:
-32 bits: Processador de 1 gigahertz (GHz) ou mais rápido de 32 bits (x86)
-64 bits: Processador de 1 gigahertz (GHz) ou mais rápido de 64 bits (x64)

-Memória:
-32 bits: 2 GB (4 GB recomendados)
-64 bits: 4 GB (8 GB recomendados)



Como utilizar o Sistema de Verificação de Matrícula
---------------------------------------------------------------------

Pensando em tornar a experiência de utilização o mais amigável possível, o Sistema apresentará um ambiente gráfico, porém simplista, com foco na eficácia.

-Inicialização do Sistema:
-Abrirá uma janela com os seguintes botões: Selecionar Arquivo; Verificar Matricula; Gerar Dígito Verificador;
- Ao clicar em Selecionar arquivo, você deverá selecionar o arquivo que contem as Matrículas em lote;
-Ao clicar em Verificar, selecionando a pasta que conterá os Resultados, ele irá verificar as Matrículas e automaticamente irá gerar o arquivo matriculasVerificadas.txt na pasta de Resultados;
-Ao clicar em Gerar Dígito Verificador, selecionando a pasta que conterá os Resultados, ele irá gerar as matrículas e automaticamente irá gerar o arquivo matriculasComDV.txt na pasta de Resultados;