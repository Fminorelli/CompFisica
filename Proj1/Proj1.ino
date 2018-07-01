const int analogInPin = A0;             // Pino analógico que o sensor está conectado
#define ledPin 9                        // Pino onde se encontram os led do LDR
int sensorValue = 0;                    // Variavel que cotem o valor do sensor de luminosidade
char junk;                              // Variavel utilizada para a remoção de lixo de memória
String inputString="";                  // Variavel utilizada para a leitura dos valores na porta serial

void setup() {
  Serial.begin(9600);                   // Inicializa a comunicação serial com a taxa de 9600 bps
  pinMode(2, OUTPUT);                   // Seta o pino 2 como saida
  pinMode(3, OUTPUT);                   // Seta o pino 3 como saida
  pinMode(4, OUTPUT);                   // Seta o pino 4 como saida
  pinMode(5, OUTPUT);                   // Seta o pino 5 como saida
  pinMode(ledPin,OUTPUT);               // Seta o pino 9 (ledPin) como saida
  digitalWrite(2, LOW); 
  digitalWrite(3, LOW); 
  digitalWrite(4, LOW); 
  digitalWrite(5, LOW); 
}

void loop() {
 
  if(Serial.available()){                 // Verifica a disposição da porta serial
  while(Serial.available()){            // Efetua a leitura dos dados na porta serial até que a mesma nao esteja mais disponivel
    char inChar = (char)Serial.read(); // Lê os dados da porta serial
    inputString += inChar;            // Cria uma string com todos os caracteres vindos da porta serial
    }
    Serial.println(inputString);
    
    while (Serial.available() > 0){   
      junk = Serial.read() ; }        // Limpa o buffer serial
      
      if(inputString == "1"){         // Caso o dado lido seja "1"
        digitalWrite(2, HIGH);
        Serial.println("led1 on"); // Liga o led na porta "2"
      }
      
      else if(inputString == "2"){   // Caso o dado lido seja "2"
        digitalWrite(2, LOW);       // Desliga o led na porta "2"
      Serial.println("led1 off");
      }
    
      if(inputString == "3"){       // Caso o dado lido seja "3"
        digitalWrite(3, HIGH);// Liga o led na porta "3"
        Serial.println("led2 on");
      }
      
      else if(inputString == "4"){   // Caso o dado lido seja "4"
        digitalWrite(3, LOW);       // Desliga o led na porta "4"
        Serial.println("led2 off");
      }
      
      if(inputString == "5"){       // Caso o dado lido seja "5"
        digitalWrite(4, HIGH);      // Liga o led na porta "5"
        Serial.println("led3 on");
      }
        
      else if(inputString == "6"){   // Caso o dado lido seja "6"
        digitalWrite(4, LOW);       // Desliga o led na porta "6"
        Serial.println("led3 off");
      }
      
      if(inputString == "7"){       // Caso o dado lido seja "7"
        digitalWrite(5, HIGH);      // Liga o led na porta "7"
        Serial.println("led4 on");
      }
        
      else if(inputString == "8"){   // Caso o dado lido seja "8"
        digitalWrite(5, LOW);       // Desliga o led na porta "8"
        Serial.println("led4 off");
      }
        inputString = "";
      }
    
    sensorValue = analogRead(analogInPin); // Faz a leitura do pino analógico
  
    Serial.print("sensor =" );            // Imprime o resultado no monitor serial
    Serial.println(sensorValue);
    delay(500);
          
  
    if(sensorValue >400 ){                // Caso o valor do sensor LDR seja >400
      analogWrite(ledPin, LOW);           // Desliga os leds da porta "9"
    }
    
    else if(sensorValue <390 && sensorValue >293) { // Caso o valor lido esteja entre 390 e 293
     analogWrite(ledPin, 10);                       // Liga os leds com intensidade 10
    }
    
    else if(sensorValue <293 && sensorValue >196) { //// Caso o valor lido esteja entre 390 e 293
     analogWrite(ledPin, 50);                       // Liga os leds com intensidade 50
    }
    
    else if(sensorValue <195 && sensorValue >99) { // Caso o valor lido esteja entre 195 e 99
     analogWrite(ledPin, 100);                      // Liga os leds com intensidade 100
    }
    
    else if(sensorValue <99 && sensorValue >0) { // Caso o valor lido esteja entre 99 e 0
     analogWrite(ledPin, 1000);                   // Liga os leds com intensidade 1000
    }

  }
