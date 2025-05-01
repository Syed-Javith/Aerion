import {JSX} from "react";

export interface Dialog {
    dialogTitle: string;
    dialogContent: JSX.Element;
    isDialogOpen: boolean;
    setDialogTitle: Function,
    setDialogContent: Function,
    setDialogOpen: Function
}