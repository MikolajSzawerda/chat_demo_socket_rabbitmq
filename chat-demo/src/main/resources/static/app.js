const url  = "http://localhost:8080/chat"
const socket = SockJS(url)
const client = Stomp.over(socket)
const messages = []
let sesID = ""
client.connect({}, {}, (res)=>{
    console.log("Connection established")
    console.log(res)
    sesID = socket._transport.url
    client.subscribe("/topic/messages", (frame)=>{
        console.log(frame)
        messages.push("Them: "+frame.body)
    })
    console.log("Subscribed!")
})

function sayhello(){
    client.send("/app/exchange", {}, "Hi from browser!")
    messages.push("Me: Hi from browser!")
}





