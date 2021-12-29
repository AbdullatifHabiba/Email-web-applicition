import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Trash',
  templateUrl: './Trash.component.html',
  styleUrls: ['./Trash.component.css']
})
export class TrashComponent implements OnInit {
  ngOnInit() {
    this.controll.getemails(this.page,"sent").subscribe(emails => this.trashemails = emails)

   this.elenum=(this.trashemails).length;
    }
    trashemails?:any=[];

    page:number=1;

    size:number=5;
    elenum:number=10;

    constructor(private controll:ComponentscontrollerService) {
    }

    getsentEmails(){
    }
    clippage(){
      this.controll.getemails(this.page,"Sent").subscribe(emails => this.trashemails = emails)

    }

    addstar(id:number){
      this.controll.star(id,"Inbox")

    }
    deletem(id:number){
      this.controll.delete(id,"Inbox")

    }
    sort(type:string){

    this.controll.Sort(type,"Inbox")

    }

    checkarray=new Array<any>();

    addcheck(id:number,ch:string){
       const item ={id:id,ch:ch}
      this. checkarray.push(item);
    }
}
