package com.uisrael.sitiosturismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.kobjects.base64.Base64;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class LogInUsersActivity extends AppCompatActivity {
    static String ip;//="192.168.1.48"; //"192.168.14.205"; //"192.168.14.106";
    static String port;
    String namespace="http://sitioWsPublic.uisrael.com//WebServiceSitio/";
    //String url="http://"+ip+":"+port+"/wsmegaalmacen/services/Bdservices?wsdl";
    String url = "http://10.0.2.2:8081/WsInterSItios/WebServiceSitio?wsdl";

    EditText userView, passView;
    Button loginView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_users);

        userView = (EditText)findViewById(R.id.edtUser);
        passView = (EditText)findViewById(R.id.edtPass);

        loginView = (Button) findViewById(R.id.btnLogin);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final Usuarios usuarios = new Usuarios();


        loginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    usuarios.setUser(userView.getText().toString());
                    usuarios.setPass(passView.getText().toString());
                    logInUsers(usuarios);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }


    public void logInUsers(Usuarios objecto) throws IOException {
        int respuesta = 0;

        final String NAMESPACE = this.namespace;
        final String URL = url;
        final String METHOD_NAME = "loginWs";
        final String SOAP_ACTION = namespace+"/"+METHOD_NAME+"/";

        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(ba);
        oos.writeObject(objecto);
        byte[] arrayBytesitos =ba.toByteArray();
        String encodedstring = Base64.encode(arrayBytesitos);

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
//      Pass value for fname variable in the web service
        PropertyInfo lnameProp =new PropertyInfo();
        lnameProp.setName("param");
        lnameProp.setValue(encodedstring);
        lnameProp.setType(String.class);
        request.addProperty(lnameProp);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            respuesta=Integer.valueOf(response.toString());


        } catch (Exception e) {
            System.out.println("Error de aqui en la conexion http"+e);
        }
    }
}
