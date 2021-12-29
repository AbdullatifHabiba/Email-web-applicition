import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Starred',
  templateUrl: './Starred.component.html',
  styleUrls: ['./Starred.component.css']
})
export class StarredComponent implements OnInit {

  ngOnInit() {
    this.controll.getemails(this.page,"sent").subscribe(emails => this.starremails = emails)

   this.elenum=(this.starremails).length;
    }
    starremails?:any=[];

    page:number=1;

    size:number=5;
    elenum:number=10;

    constructor(private controll:ComponentscontrollerService) {
    }

    getsentEmails(){
    }
    clippage(){
      this.controll.getemails(this.page,"Sent").subscribe(emails => this.starremails = emails)

    }
addimportant(id:number){}
addstar(id:number){}
addspam(id:number){}
deletem(id:number){}
sort(type:string){

  console.log(type)
}
checkarray=new Array<any>();

    addcheck(id:number,ch:string){
       const item ={id:id,ch:ch}
      this. checkarray.push(item);
    }


}
