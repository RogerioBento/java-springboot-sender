package br.com.rest.sender.api.constant;

public class UriConstants {

    // PARAMETERS
    private static final String ID_PARAMETER = "/{id}";
    private static final String NOME_PARAMETER = "/{nome}";

    // VERSIONS
    private static final String VERSION_1 = "/v1";

    // ENDPOINTS
    private static final String ENDPOINT_CARROS = "/carros";
    private static final String ENDPOINT_MODELOS = "/modelos";
    private static final String ENDPOINT_NOME = "/nome";

    public static class SenderCarro {

        public static final String V1_Carro = VERSION_1 + ENDPOINT_CARROS;
        public static final String V1_Carro_Id = VERSION_1 + ENDPOINT_CARROS + ID_PARAMETER;
        public static final String V1_Carro_Nome = VERSION_1 + ENDPOINT_CARROS + ENDPOINT_NOME + NOME_PARAMETER;
    }

    public static class SenderModelo {

        public static final String V1_Modelo = VERSION_1 + ENDPOINT_MODELOS;
        public static final String V1_Modelo_Id = VERSION_1 + ENDPOINT_MODELOS + ID_PARAMETER;
        public static final String V1_Modelo_Nome = VERSION_1 + ENDPOINT_MODELOS + ENDPOINT_NOME + NOME_PARAMETER;
    }

    public static class ReceiverCarro {

        public static final String V1_Carro = VERSION_1 +ENDPOINT_CARROS;
        public static final String V1_Carro_Id = VERSION_1 +ENDPOINT_CARROS + ID_PARAMETER;
        public static final String V1_Carro_Nome = VERSION_1 +ENDPOINT_CARROS + ENDPOINT_NOME + NOME_PARAMETER;
    }

    public static class ReceiverModelo {

        public static final String V1_Modelo = VERSION_1 + ENDPOINT_MODELOS;
        public static final String V1_Modelo_Id = VERSION_1 + ENDPOINT_MODELOS + ID_PARAMETER;
        public static final String V1_Modelo_Nome = VERSION_1 + ENDPOINT_MODELOS + ENDPOINT_NOME + NOME_PARAMETER;
    }
}