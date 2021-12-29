import { EmailDetialsComponent } from './../EmailDetials/EmailDetials.component';
import { FormGroup } from '@angular/forms';
import { Email } from './../Email';
import { Component, OnInit, Output } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit  {

  ngOnInit() {
    this.controll.getemails(this.page,"sent").subscribe(emails => this.inboxemails = emails)
    this.inboxemails=[{to:"Abdellatif",from:"ahmed",subject:"projec"}]


   this.elenum=(this.inboxemails).length;
    }
    inboxemails?:any=[];

    page:number=1;

    size:number=5;
    elenum:number=10;

    constructor(private controll:ComponentscontrollerService) {
    }

    getsentEmails(){
    }
    clippage(){
      this.controll.getemails(this.page,"Sent").subscribe(emails => this.inboxemails = emails)

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



