import {createContext, JSX, ReactNode, useState} from "react";
import {Dialog} from "./models/Dialog";

export const DialogContext = createContext<Dialog>({
    dialogTitle: "",
    dialogContent: <></>,
    isDialogOpen: false,
    setDialogTitle: () => {},
    setDialogContent: () => {},
    setDialogOpen: () => {}
});

export const UIContext = ({ children } : { children: ReactNode }) => {

    const [dialogTitle, setDialogTitle] = useState<string>('');
    const [dialogContent, setDialogContent] = useState<JSX.Element>(<></>);
    const [isDialogOpen, setDialogOpen] = useState<boolean>(false);

    return (
        <DialogContext.Provider value={{dialogTitle, setDialogTitle, dialogContent, setDialogContent, isDialogOpen, setDialogOpen}}>
            {children}
        </DialogContext.Provider>
    );
};
