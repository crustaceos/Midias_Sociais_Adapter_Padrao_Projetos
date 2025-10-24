Exercício a respeito de um sistema de integração de API's de Mídia Social utilizando o padrão adapter, factory e strategy.

As Mídias Sociais utilizadas foram: Twitter, Instagram, TikTok e LinkedIn.  

Cada rede social possui uma "API" própria com métodos simples. A "API" se refere a métodos específicos pré-definidos, apenas para execução do código, sem qualquer tipo de ligação com API's reais. 
Dessa maneira, os adapters padronizam essas interações, permitindo que todas sejam usadas da mesma forma na aplicação principal.

Foi criada uma interface comum, "MidiaSocial" para definir todos os métodos que as redes sociais devem implementar.
De forma que, cada adapter, converte a lógica específica de cada API para o padrão definido em "Mídia Social".
A Factory possui o papel de retornar cada adapter a sua respectiva plataforma.

O diagrama de classes foi realizado no site PlantUML, mas foi alocado no Miro para facilitar o compartilhamento:
https://miro.com/app/board/uXjVJ1JB8Ns=/?focusWidget=3458764645533068912
