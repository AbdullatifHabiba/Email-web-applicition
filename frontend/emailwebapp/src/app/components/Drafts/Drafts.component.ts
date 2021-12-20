import { Component, OnInit } from '@angular/core';
import { Email } from '../Email';

@Component({
  selector: 'app-Drafts',
  templateUrl: './Drafts.component.html',
  styleUrls: ['./Drafts.component.css']
})
export class DraftsComponent implements OnInit {

  constructor() { }


  Draftitem?:Array<Email>;

  ngOnInit() {
  }

}
