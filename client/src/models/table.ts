export type Constructor<T> = new (...args: any[]) => T;

export function createInstance<T>(clazz: Constructor<T>, ...args: any[]): T {
    return new clazz(...args);
}

export interface TableConfiguration {
    headers?: string[],
    url: string,
    dataClass: Constructor<any>,
    parseFunc?: Function,
    rows?: string[],
    filterOpts: TableFilter,
    columnMetaData: { [key: string]: { key: string, filterKey: string } },
}

export type TableFilter = { [key: string]: Set<string> };