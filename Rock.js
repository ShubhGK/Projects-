 let score ={
    win:0,
    loose:0,
    tie:0
 }
 let Result ='' 
 function genrateComputerInput(){
    let randomValue=Math.random();
    let computerInput;
    console.log(randomValue);
    if(randomValue>=0 && randomValue<1/3){
        computerInput='Rock';
    }
    else if(randomValue>=1/3 && randomValue<2/3){
        computerInput='Paper';
    }
    else{
        computerInput='Scissor';
    }
    return computerInput;
 }

 function PlayGame(PlayerChoice){
    computerInput = genrateComputerInput();
    if(PlayerChoice === 'Rock'){
        if(computerInput==='Rock'){
            Result = "It's Tie"
        }
        else if(computerInput==='Paper'){
            Result ="You loose"
        }
        else{
            Result = "You win"
        }
    }
    else if(PlayerChoice === 'Paper'){
        if(computerInput==='Paper'){
            Result = "It's Tie";
        }
        else if(computerInput==='Scissor'){
            Result = "You loose";
        }
        else{
            Result = "You win";
        }
    }
    else if(PlayerChoice === 'Scissor'){
        if(computerInput==='Paper'){
            Result = "You win";
         }
         else if(computerInput==='Scissor'){
             Result = "It's Tie";
         }
         else{
             Result = "You loose";
         }
    }
    if(Result == "You win"){
        score.win+= 1
    }
    else if(Result == "You loose"){
        score.loose+=1
    }
    else if(Result == "It's Tie"){
        score.tie+=1
    }
    alert(`You choose ${PlayerChoice} Computer Choose ${computerInput} The Result is${Result}
    win: ${score.win}   Loose: ${score.loose}   tie: ${score.tie}`)
    document.getElementById('Player').innerHTML  = score.win
    document.getElementById('Computer').innerHTML = score.loose
 }
 function Reset(){
    score.win=0;
    score.loose=0;
    score.tie=0;
    document.getElementById('Player').innerHTML=0;
    document.getElementById('Computer').innerHTML=0;
 }
