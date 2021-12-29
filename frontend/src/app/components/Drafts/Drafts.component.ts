import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Drafts',
  templateUrl: './Drafts.component.html',
  styleUrls: ['./Drafts.component.css']
})
export class DraftsComponent implements OnInit {

  ngOnInit() {
    this.controll.getemails(this.page,"Drafts").subscribe(emails => this.DraftEmails = emails)
    this.DraftEmails=[{to:"ahmed",from:"ahmed",subject:"ahmed"}]
   this.elenum=(this.DraftEmails).length;
    }
    DraftEmails?:any=[];

    page:number=1;

    size:number=5;
    elenum:number=10;

    constructor(private controll:ComponentscontrollerService) {
    }

    getsentEmails(){
    }
    clippage(){
      this.controll.getemails(this.page,"Drafts").subscribe(emails => this.DraftEmails = emails)

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

