import { FaceSnapsService } from './../services/face-snaps.service';
import { FaceSnap } from './../models/face-snap.model';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-face-snap',
  templateUrl: './face-snap.component.html',
  styleUrls: ['./face-snap.component.scss']
})

export class FaceSnapComponent {

  @Input() faceSnapp!: FaceSnap;
  snapped!: boolean;

  constructor(private faceSnapsService: FaceSnapsService, private router: Router) {};

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.snapped = false;
  }

  onAddSnap() {
    if (this.snapped === false) {
      this.faceSnapsService.snapFaceSnapById(this.faceSnapp.id, 'snap');
      this.snapped = true;
    } else {
      this.faceSnapsService.snapFaceSnapById(this.faceSnapp.id, 'unsnap');
      this.snapped = false;
    }
  }

  onViewFaceSnap() {
    this.router.navigateByUrl(`facesnaps/${this.faceSnapp.id}`);
  }
}
