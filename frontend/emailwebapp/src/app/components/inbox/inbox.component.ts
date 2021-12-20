import { Email } from './../Email';
import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent  {

  constructor() {
  this.list?.push({name:"Ahmed",time:"5:54Am"})
  this.list?.push({name:"saad",time:"5:522Am"})}


list?:Array<Email>;

add(){


}
}




